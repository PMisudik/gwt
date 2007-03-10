/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.emultest.java.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO: document me.
 */
public class ArraysTest extends EmulTestBase {
  public String getModuleName() {
    return "com.google.gwt.emultest.EmulSuite";
  }

  public void testAsList() {
    // 0
    Object[] test = {};
    List result = Arrays.asList(test);
    assertEquals(test, result);
    // n
    Object[] test2 = {new Integer(0), new Integer(1), new Integer(2)};
    List result2 = Arrays.asList(test2);
    assertEquals(test2, result2);
    // 1
    Object[] test3 = {"Hello"};
    List result3 = Arrays.asList(test3);
    assertEquals(test3, result3);
  }

  public void testSimpleSort() {
    // empty case
    Object[] test = {};
    Arrays.sort(test);
    assertEquals(test.length, 0);
    // single case
    Integer[] test2 = {new Integer(1)};
    Arrays.sort(test2);
    assertEquals(1, test2[0].intValue());
    // multiple case with subclassing
    Number[] test3 = {
        new Integer(3), new Integer(0), new Integer(2), new Integer(4),
        new Integer(1)};
    Arrays.sort(test3);
    for (int i = 0; i < test3.length; i++) {
      assertEquals(i, test3[i].intValue());
    }
  }

  public void testSort() {
    Object[] x = {"c", "b", "b", "a"};
    int hash = x[1].hashCode();
    Arrays.sort(x);
    int hash2 = x[1].hashCode();
    assertEquals(hash, hash2);
    Object[] sorted = {"a", "b", "b", "c"};
    assertEquals(x, sorted);
    Comparator t = new Comparator() {
      public int compare(Object o1, Object o2) {
        return ((Comparable) o2).compareTo(o1);
      }
    };
    Arrays.sort(x, t);
    int hash3 = x[1].hashCode();
    assertEquals(hash, hash3);
    Object[] reverseSorted = {"c", "b", "b", "a"};
    assertEquals(x, reverseSorted);
  }
}
