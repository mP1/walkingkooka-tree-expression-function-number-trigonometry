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
import walkingkooka.collect.set.Sets;
import walkingkooka.net.Url;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionFunctionName;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberFunctions;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProvider;
import walkingkooka.tree.expression.function.provider.ExpressionFunctionProviders;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class NumberTrigonomteryExpressionFunctions implements PublicStaticHelper {

    /**
     * An {@link ExpressionFunctionProvider} with all the functions in this project.
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunctionProvider<C> expressionFunctionProvider(final CaseSensitivity nameCaseSensitivity) {
        return ExpressionFunctionProviders.basic(
            Url.parseAbsolute("https://github.com/mP1/walkingkooka-tree-expression-function-number-trigonometry/"),
            nameCaseSensitivity,
            Sets.of(
                acos(),
                asin(),
                atan(),
                cos(),
                cosh(),
                degrees(),
                pi(),
                radians(),
                sin(),
                sinh(),
                tan(),
                tanh()
            )
        );
    }

    /**
     * ACOS
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> acos() {
        return Cast.to(ACOS);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> ACOS = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::acos,
        Math::acos
    ).function(functionName("acos"));

    /**
     * ASIN
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> asin() {
        return Cast.to(ASIN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> ASIN = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::asin,
        Math::asin
    ).function(functionName("asin"));

    /**
     * ATAN
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> atan() {
        return Cast.to(ATAN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> ATAN = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::atan,
        Math::atan
    ).function(functionName("atan"));

    /**
     * COS
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> cos() {
        return Cast.to(COS);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> COS = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::cos,
        Math::cos
    ).function(functionName("cos"));

    /**
     * COSH
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> cosh() {
        return Cast.to(COSH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> COSH = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::cosh,
        Math::cosh
    ).function(functionName("cosh"));

    /**
     * DEGREES
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> degrees() {
        return Cast.to(DEGREES);
    }

    private final static BigDecimal ONE_EIGHTY = new BigDecimal("180");

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> DEGREES = ExpressionNumberFunctions.lambdas(
        (v, mc) -> v.multiply(
            ONE_EIGHTY.divide(
                BigDecimalMath.pi(mc),
                mc
            )
        ),
        Math::toDegrees
    ).function(functionName("degrees"));

    /**
     * {@see NumberExpressionFunctionPi}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> pi() {
        return NumberExpressionFunctionPi.instance();
    }

    /**
     * RADIANS
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> radians() {
        return Cast.to(RADIANS);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> RADIANS = ExpressionNumberFunctions.lambdas(
        (v, mc) -> v.multiply(
            BigDecimalMath.pi(mc).divide(
                ONE_EIGHTY,
                mc
            )
        ),
        Math::toRadians
    ).function(functionName("radians"));

    /**
     * SIN
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> sin() {
        return Cast.to(SIN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> SIN = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::sin,
        Math::sin
    ).function(functionName("sin"));

    /**
     * SINH
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> sinh() {
        return Cast.to(SINH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> SINH = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::sinh,
        Math::sinh
    ).function(functionName("sinh"));

    /**
     * TAN
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> tan() {
        return Cast.to(TAN);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> TAN = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::tan,
        Math::tan
    ).function(functionName("tan"));

    /**
     * TANH
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> tanh() {
        return Cast.to(TANH);
    }

    private final static ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> TANH = ExpressionNumberFunctions.lambdas(
        BigDecimalMath::tanh,
        Math::tanh
    ).function(functionName("tanh"));

    private static Optional<ExpressionFunctionName> functionName(final String name) {
        return Optional.of(
            ExpressionFunctionName.with(name)
        );
    }

    /**
     * Stops creation
     */
    private NumberTrigonomteryExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
