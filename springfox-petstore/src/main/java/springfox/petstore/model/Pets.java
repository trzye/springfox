/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.petstore.model;


import com.google.common.base.Objects;
import com.google.common.base.Predicate;

import static com.google.common.collect.Iterables.*;

public class Pets {
  public static Predicate<Pet> statusIs(final String status) {
    return new Predicate<Pet>() {
      @Override
      public boolean apply(Pet input) {
        return Objects.equal(input.getStatus(), status);
      }
    };
  }

  public static Predicate<Pet> tagsContain(final String tag) {
    return new Predicate<Pet>() {
      @Override
      public boolean apply(Pet input) {
        return any(input.getTags(), withName(tag));
      }
    };
  }

  private static Predicate<Tag> withName(final String tag) {
    return new Predicate<Tag>() {
      @Override
      public boolean apply(Tag input) {
        return Objects.equal(input.getName(), tag);
      }
    };
  }
}
