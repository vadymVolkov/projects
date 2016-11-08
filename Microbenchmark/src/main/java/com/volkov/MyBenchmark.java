/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.volkov;


import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Fork(3)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
public class MyBenchmark {

    @State(Scope.Thread)
    public static class MyState {
        public List<Integer> arrayList;
        public List<Integer> linkedList;

        @Setup(Level.Trial)
        public void setUp() {
            arrayList = new ArrayList<>(Collections.nCopies(1000, 0));
            linkedList = new LinkedList<>(arrayList);
        }
    }



   /* @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testArrayListFor1(MyState state, Blackhole blackhole) {
        Integer element = state.arrayList.get(1);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testLinkedListFor1(MyState state, Blackhole blackhole) {
        Integer element = state.linkedList.get(1);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testArrayListFor5(MyState state, Blackhole blackhole) {
        Integer element = state.arrayList.get(5);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testLinkedListFor15(MyState state, Blackhole blackhole) {
        Integer element = state.linkedList.get(5);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testArrayListFor50(MyState state, Blackhole blackhole) {
        Integer element = state.arrayList.get(50);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testLinkedListFor50(MyState state, Blackhole blackhole) {
        Integer element = state.linkedList.get(50);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testArrayListFor900(MyState state, Blackhole blackhole) {
        Integer element = state.arrayList.get(900);
        blackhole.consume(element);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testLinkedListFor900(MyState state, Blackhole blackhole) {
        Integer element = state.linkedList.get(900);
        blackhole.consume(element);
    }*/
    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testArrayListAddFor1(MyState state) {
        state.arrayList.add(900,900);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testLinkedListAddFor1(MyState state) {
        state.linkedList.add(900,900);
    }


}
