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

import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.set.SortedSets;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunction;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class NumberTrigonometryExpressionFunctionsTest implements PublicStaticHelperTesting<NumberTrigonometryExpressionFunctions>,
    ToStringTesting<NumberTrigonometryExpressionFunctions> {

    @Test
    public void testExpressionFunctionProvider() {
        this.checkEquals(
            Arrays.stream(NumberTrigonometryExpressionFunctions.class.getDeclaredMethods())
                .filter(m -> m.getReturnType() == ExpressionFunction.class)
                .map(Method::getName)
                .collect(Collectors.toCollection(SortedSets::tree)),
            NumberTrigonometryExpressionFunctions.expressionFunctionProvider(CaseSensitivity.SENSITIVE)
                .expressionFunctionInfos()
                .stream()
                .map(i -> i.name().value())
                .collect(Collectors.toCollection(SortedSets::tree))
        );
    }

    // acos............................................................................................................

    @Test
    public void testAcosBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.acos(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("1.047198")
        );
    }

    @Test
    public void testAcosDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.acos(),
            0.5,
            Math.acos(0.5)
        );
    }

    @Test
    public void testAcosToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.acos(),
            "acos"
        );
    }

    // asin............................................................................................................

    @Test
    public void testAsinBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.asin(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.5235988")
        );
    }

    @Test
    public void testAsinDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.asin(),
            0.5,
            Math.asin(0.5)
        );
    }

    @Test
    public void testAsinToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.asin(),
            "asin"
        );
    }

    // atan............................................................................................................

    @Test
    public void testAtanBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.atan(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.4636476")
        );
    }

    @Test
    public void testAtanDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.atan(),
            0.5,
            Math.atan(0.5)
        );
    }

    @Test
    public void testAtanToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.atan(),
            "atan"
        );
    }

    // cos............................................................................................................

    @Test
    public void testCosBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.cos(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.8775826")
        );
    }

    @Test
    public void testCosDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.cos(),
            0.5,
            Math.cos(0.5)
        );
    }

    @Test
    public void testCosToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.cos(),
            "cos"
        );
    }

    // cosh............................................................................................................

    @Test
    public void testCoshBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.cosh(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("1.127626")
        );
    }

    @Test
    public void testCoshDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.cosh(),
            0.5,
            Math.cosh(0.5)
        );
    }

    @Test
    public void testCoshToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.cosh(),
            "cosh"
        );
    }

    // degrees............................................................................................................

    @Test
    public void testDegreesBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.degrees(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("28.647885")
        );
    }

    @Test
    public void testDegreesDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.degrees(),
            0.5,
            Math.toDegrees(0.5)
        );
    }

    @Test
    public void testDegreesToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.degrees(),
            "degrees"
        );
    }

    // radians............................................................................................................

    @Test
    public void testRadiansBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.radians(),
            BigDecimal.valueOf(30),
            new BigDecimal("0.5235987")
        );
    }

    @Test
    public void testRadiansDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.radians(),
            30,
            Math.toRadians(30)
        );
    }

    @Test
    public void testRadiansToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.radians(),
            "radians"
        );
    }

    // sin............................................................................................................

    @Test
    public void testSinBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.sin(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.4794255")
        );
    }

    @Test
    public void testSinDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.sin(),
            0.5,
            Math.sin(0.5)
        );
    }

    @Test
    public void testSinToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.sin(),
            "sin"
        );
    }

    // sinh............................................................................................................

    @Test
    public void testSinhBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.sinh(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.5210953")
        );
    }

    @Test
    public void testSinhDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.sinh(),
            0.5,
            Math.sinh(0.5)
        );
    }

    @Test
    public void testSinhToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.sinh(),
            "sinh"
        );
    }

    // tan............................................................................................................

    @Test
    public void testTanBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.tan(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.5463025")
        );
    }

    @Test
    public void testTanDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.tan(),
            0.5,
            Math.tan(0.5)
        );
    }

    @Test
    public void testTanToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.tan(),
            "tan"
        );
    }

    // tanh............................................................................................................

    @Test
    public void testTanhBigDecimal() {
        this.mapBigDecimalAndCheck(
            NumberTrigonometryExpressionFunctions.tanh(),
            BigDecimal.valueOf(0.5),
            new BigDecimal("0.4621172")
        );
    }

    @Test
    public void testTanhDouble() {
        this.mapDoubleAndCheck(
            NumberTrigonometryExpressionFunctions.tanh(),
            0.5,
            Math.tanh(0.5)
        );
    }

    @Test
    public void testTanhToString() {
        this.toStringAndCheck(
            NumberTrigonometryExpressionFunctions.tanh(),
            "tanh"
        );
    }

    private void mapBigDecimalAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> function,
                                       final BigDecimal value,
                                       final BigDecimal expected) {
        this.mapAndCheck(
            function,
            value,
            ExpressionNumberKind.BIG_DECIMAL,
            expected
        );
    }

    private void mapDoubleAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> function,
                                   final double value,
                                   final double expected) {
        this.mapAndCheck(
            function,
            value,
            ExpressionNumberKind.DOUBLE,
            expected
        );
    }

    private <T extends Number> void mapAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext> function,
                                                final T value,
                                                final ExpressionNumberKind kind,
                                                final T expected) {
        this.checkEquals(
            kind.create(expected),
            function.apply(
                Lists.of(
                    kind.create(value)
                ),
                this.context(kind)
            ),
            () -> function + " " + value
        );
    }

    private ExpressionEvaluationContext context(final ExpressionNumberKind kind) {
        return new FakeExpressionEvaluationContext() {
            @Override
            public ExpressionNumberKind expressionNumberKind() {
                return kind;
            }

            @Override
            public MathContext mathContext() {
                return MathContext.DECIMAL32;
            }

            @Override
            public String toString() {
                return this.expressionNumberKind() + " " + this.mathContext();
            }
        };
    }

    public void testCheckToStringOverridden() {
        throw new UnsupportedOperationException();
    }

    // PublicStaticHelperTesting........................................................................................

    @Test
    public void testPublicStaticMethodsWithoutMathContextParameter() {
        this.publicStaticMethodParametersTypeCheck(MathContext.class);
    }

    @Override
    public Class<NumberTrigonometryExpressionFunctions> type() {
        return NumberTrigonometryExpressionFunctions.class;
    }

    @Override
    public boolean canHavePublicTypes(final Method method) {
        return false;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
