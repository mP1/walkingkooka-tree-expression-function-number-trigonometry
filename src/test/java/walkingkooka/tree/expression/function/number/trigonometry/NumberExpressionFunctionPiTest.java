/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
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
 *
 */

package walkingkooka.tree.expression.function.number.trigonometry;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.FakeExpressionFunctionContext;

import java.math.MathContext;
import java.text.DecimalFormat;

public final class NumberExpressionFunctionPiTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionPi<ExpressionFunctionContext>> {

    @Test
    public void testBigDecimalPi() {
        final ExpressionNumber number = this.createBiFunction()
                .apply(
                        Lists.empty(),
                        new FakeExpressionFunctionContext() {
                            @Override
                            public ExpressionNumberKind expressionNumberKind() {
                                return ExpressionNumberKind.BIG_DECIMAL;
                            }

                            @Override
                            public MathContext mathContext() {
                                return MathContext.DECIMAL32;
                            }
                        }
                );
        this.checkEquals(
                "3.142",
                new DecimalFormat("#.000").format(number)
        );
    }

    @Test
    public void testDoublePi() {
        this.applyAndCheck(
                Lists.empty(),
                new FakeExpressionFunctionContext() {
                    @Override
                    public ExpressionNumberKind expressionNumberKind() {
                        return ExpressionNumberKind.DOUBLE;
                    }
                },
                ExpressionNumberKind.DOUBLE.create(Math.PI)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createBiFunction(), "pi");
    }

    @Override
    public NumberExpressionFunctionPi<ExpressionFunctionContext> createBiFunction() {
        return NumberExpressionFunctionPi.instance();
    }

    @Override
    public Class<NumberExpressionFunctionPi<ExpressionFunctionContext>> type() {
        return Cast.to(NumberExpressionFunctionPi.class);
    }
}
