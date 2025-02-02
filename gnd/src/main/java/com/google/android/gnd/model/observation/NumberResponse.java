/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gnd.model.observation;

import androidx.annotation.NonNull;
import com.google.android.gnd.model.form.Field;
import java8.util.Optional;

/** A user provided response to a number {@link Field}. */
public class NumberResponse implements Response {

  private Number number;

  public NumberResponse(Number number) {
    this.number = number;
  }

  public double getValue() {
    return number.doubleValue();
  }

  @Override
  public String getSummaryText(Field field) {
    return number.toString();
  }

  @Override
  public String getDetailsText(Field field) {
    if (Double.isNaN(number.doubleValue())) {
      return "";
    }
    return number.toString();
  }

  @Override
  public boolean isEmpty() {
    return number.toString().isEmpty();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof NumberResponse) {
      return number.equals(((NumberResponse) obj).number);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }

  @NonNull
  @Override
  public String toString() {
    return number.toString();
  }

  public static Optional<Response> fromNumber(Number number) {
    return number.toString().isEmpty()
        ? Optional.empty()
        : Optional.of(new NumberResponse(number));
  }
}
