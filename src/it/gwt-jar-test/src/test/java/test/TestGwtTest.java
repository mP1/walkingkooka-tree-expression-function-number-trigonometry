package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.Either;
import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.locale.LocaleAware;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.number.trigonometry.NumberTrigonomteryExpressionFunctions;

import java.math.MathContext;

@LocaleAware
public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
            1,
            1
        );
    }

    public void testCos() {
        final ExpressionNumberKind kind = ExpressionNumberKind.DOUBLE;

        assertEquals(
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
