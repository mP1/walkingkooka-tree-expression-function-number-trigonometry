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
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.TypeNameTesting;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionTesting;

import java.util.List;
import java.util.stream.Collectors;

public abstract class NumberExpressionFunctionTestCase<F extends ExpressionFunction<ExpressionNumber, ExpressionEvaluationContext>>
        implements ExpressionFunctionTesting<F, ExpressionNumber, ExpressionEvaluationContext>,
        ClassTesting2<F>,
        TypeNameTesting<F> {

    final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    NumberExpressionFunctionTestCase() {
        super();
    }

    @Test
    public final void testIsPureTrue() {
        this.isPureAndCheck(
                this.createBiFunction(),
                ExpressionEvaluationContexts.fake(),
                true
        );
    }

    @Override
    public final void applyAndCheck2(final F function,
                                     final List<Object> parameters,
                                     final ExpressionNumber result) {
        this.applyAndCheck2(
                function,
                parameters.stream()
                        .map(i -> KIND.create((Number) i))
                        .collect(Collectors.toList()),
                this.createContext(),
                result
        );
    }

    @Override
    public final ExpressionEvaluationContext createContext() {
        return new FakeExpressionEvaluationContext() {
            @Override
            public ExpressionNumberKind expressionNumberKind() {
                return KIND;
            }
        };
    }

    @Override
    public final JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }


    @Override
    public final String typeNamePrefix() {
        return NumberExpressionFunction.class.getSimpleName();
    }

    @Override
    public final String typeNameSuffix() {
        return "";
    }
}
