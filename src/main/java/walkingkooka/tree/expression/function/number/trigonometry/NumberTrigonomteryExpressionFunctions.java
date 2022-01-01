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

/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberFunctions;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class NumberTrigonomteryExpressionFunctions implements PublicStaticHelper {

    /**
     * Visit all {@link ExpressionFunction functions}.
     */
    public static void visit(final Consumer<ExpressionFunction<?, ?>> consumer) {
        Lists.of(
                acos(),
                asin(),
                atan(),
                cos(),
                cosh(),
                degrees(),
                pi(),
                sin(),
                sinh(),
                tan(),
                tanh()
        ).forEach(consumer);
    }

    /**
     * ACOS
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> acos() {
        return Cast.to(ACOS);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> ACOS = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::acos,
            Math::acos
    ).function(FunctionExpressionName.with("acos"));

    /**
     * ASIN
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> asin() {
        return Cast.to(ASIN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> ASIN = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::asin,
            Math::asin
    ).function(FunctionExpressionName.with("asin"));

    /**
     * ATAN
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> atan() {
        return Cast.to(ATAN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> ATAN = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::atan,
            Math::atan
    ).function(FunctionExpressionName.with("atan"));

    /**
     * COS
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> cos() {
        return Cast.to(COS);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> COS = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::cos,
            Math::cos
    ).function(FunctionExpressionName.with("cos"));

    /**
     * COSH
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> cosh() {
        return Cast.to(COSH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> COSH = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::cosh,
            Math::cosh
    ).function(FunctionExpressionName.with("cosh"));

    /**
     * DEGREES
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> degrees() {
        return Cast.to(DEGREES);
    }

    private final static BigDecimal ONE_EIGHTY = new BigDecimal("180");

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> DEGREES = ExpressionNumberFunctions.lambdas(
            (v, mc) -> v.multiply(
                    ONE_EIGHTY.divide(
                            BigDecimalMath.pi(mc),
                            mc
                    )
            ),
            Math::toDegrees
    ).function(FunctionExpressionName.with("degrees"));

    /**
     * {@see NumberExpressionFunctionPi}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> pi() {
        return NumberExpressionFunctionPi.instance();
    }

    /**
     * SIN
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> sin() {
        return Cast.to(SIN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> SIN = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::sin,
            Math::sin
    ).function(FunctionExpressionName.with("sin"));

    /**
     * SINH
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> sinh() {
        return Cast.to(SINH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> SINH = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::sinh,
            Math::sinh
    ).function(FunctionExpressionName.with("sinh"));

    /**
     * TAN
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> tan() {
        return Cast.to(TAN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> TAN = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::tan,
            Math::tan
    ).function(FunctionExpressionName.with("tan"));

    /**
     * TANH
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> tanh() {
        return Cast.to(TANH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> TANH = ExpressionNumberFunctions.lambdas(
            BigDecimalMath::tanh,
            Math::tanh
    ).function(FunctionExpressionName.with("tanh"));

    /**
     * Stops creation
     */
    private NumberTrigonomteryExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
