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

import ch.obermuhlner.math.big.BigDecimalMath;
import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberFunction;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.math.BigDecimal;
import java.math.MathContext;

final class AcosExpressionNumberFunction implements ExpressionNumberFunction {

    static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> INSTANCE = new AcosExpressionNumberFunction()
            .function(FunctionExpressionName.with("acos"));

    AcosExpressionNumberFunction() {
        super();
    }

    @Override
    public BigDecimal mapBigDecimal(final BigDecimal value,
                                    final MathContext context) {
        return BigDecimalMath.acos(value, context);
    }

    @Override
    public double mapDouble(final double value) {
        return Math.acos(value);
    }

    @Override
    public String toString() {
        return "acos";
    }
}
