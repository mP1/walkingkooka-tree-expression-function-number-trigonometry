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
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.tree.expression.ExpressionNumberFunctionTesting;

public final class AcosExpressionNumberFunctionTest implements ExpressionNumberFunctionTesting<AcosExpressionNumberFunction>,
        ClassTesting<AcosExpressionNumberFunction>,
        ToStringTesting<AcosExpressionNumberFunction> {

    @Test
    public void testDouble() {
        this.mapDoubleAndCheck(
                0.5,
                Math.acos(0.5)
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createExpressionNumberFunction(), "acos");
    }

    @Override
    public AcosExpressionNumberFunction createExpressionNumberFunction() {
        return new AcosExpressionNumberFunction();
    }

    @Override
    public Class<AcosExpressionNumberFunction> type() {
        return AcosExpressionNumberFunction.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
