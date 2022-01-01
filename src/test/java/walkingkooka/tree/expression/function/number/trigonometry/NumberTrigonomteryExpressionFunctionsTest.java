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
import walkingkooka.collect.set.Sets;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.FakeExpressionFunctionContext;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class NumberTrigonomteryExpressionFunctionsTest implements PublicStaticHelperTesting<NumberTrigonomteryExpressionFunctions>,
        ToStringTesting<NumberTrigonomteryExpressionFunctions> {

    @Test
    public void testVisit() {
        final Set<FunctionExpressionName> names = Sets.sorted();
        NumberTrigonomteryExpressionFunctions.visit((e) -> names.add(e.name()));

        this.checkEquals(Arrays.stream(NumberTrigonomteryExpressionFunctions.class.getDeclaredMethods())
                        .filter(m -> m.getReturnType() == ExpressionFunction.class)
                        .map(Method::getName)
                        .collect(Collectors.toCollection(Sets::sorted))
                        .size(),
                names.size());
        this.checkEquals(true, names.contains(NumberTrigonomteryExpressionFunctions.acos().name()));
    }

    // acos............................................................................................................

    @Test
    public void testAcosBigDecimal() {
        this.mapBigDecimalAndCheck(
                NumberTrigonomteryExpressionFunctions.acos(),
                BigDecimal.valueOf(0.5),
                new BigDecimal("1.047198")
        );
    }

    @Test
    public void testAcosDouble() {
        this.mapDoubleAndCheck(
                NumberTrigonomteryExpressionFunctions.acos(),
                0.5,
                Math.acos(0.5)
        );
    }

    @Test
    public void testAcosToString() {
        this.toStringAndCheck(
                NumberTrigonomteryExpressionFunctions.acos(),
                "acos"
        );
    }

    private void mapBigDecimalAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> function,
                                       final BigDecimal value,
                                       final BigDecimal expected) {
        this.mapAndCheck(
                function,
                value,
                ExpressionNumberKind.BIG_DECIMAL,
                expected
        );
    }

    private void mapDoubleAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> function,
                                   final double value,
                                   final double expected) {
        this.mapAndCheck(
                function,
                value,
                ExpressionNumberKind.DOUBLE,
                expected
        );
    }

    private <T extends Number> void mapAndCheck(final ExpressionFunction<ExpressionNumber, ExpressionFunctionContext> function,
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

    private ExpressionFunctionContext context(final ExpressionNumberKind kind) {
        return new FakeExpressionFunctionContext() {
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
    public Class<NumberTrigonomteryExpressionFunctions> type() {
        return NumberTrigonomteryExpressionFunctions.class;
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
