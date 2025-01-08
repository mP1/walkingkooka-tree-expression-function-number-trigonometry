/*
 * Copyright © 2020 Miroslav Pokorny
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test;


import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;

import walkingkooka.Either;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.number.trigonometry.NumberTrigonomteryExpressionFunctions;

import java.math.MathContext;

@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testTrue() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testCos() {
        final ExpressionNumberKind kind = ExpressionNumberKind.DOUBLE;

        Assert.assertEquals(
            kind.create(Math.cos(1)),
            NumberTrigonomteryExpressionFunctions.cos()
                .apply(
                    Lists.of(
                        kind.one()
                    ),
                    new FakeExpressionEvaluationContext() {

                        @Override
                        public <T> Either<T, String> convert(final Object value,
                                                             final Class<T> target) {
                            return this.successfulConversion(
                                value,
                                target
                            );
                        }

                        @Override
                        public MathContext mathContext() {
                            return MathContext.DECIMAL128;
                        }
                    }
                )
        );
    }
}
