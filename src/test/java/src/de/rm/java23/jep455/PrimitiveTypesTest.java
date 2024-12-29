package src.de.rm.java23.jep455;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimitiveTypesTest {

    @Nested
    class Grades {
        private static Stream<Arguments> gradeMapping() {
            return Stream.of(
                    Arguments.of(1, "very good"),
                    Arguments.of(2, "good"),
                    Arguments.of(3, "satisfactory"),
                    Arguments.of(4, "sufficient"),
                    Arguments.of(5, "poor"),
                    Arguments.of(6, "deficient")
            );
        }

        @ParameterizedTest
        @MethodSource("gradeMapping")
        void handle_grades(int grade, String gradeString) {
            // when
            var actual = PrimitiveTypes.printGrade(grade);

            // then
            assertThat(actual).isEqualTo(gradeString);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 7, 8})
        void handle_grades_out_of_range(int grade) {
            // when
            var actual = PrimitiveTypes.printGrade(grade);

            // then
            assertThat(actual).isEqualTo("Undefined grade: " + grade);
        }
    }

    @Nested
    class CheckBytes {
        @Test
        void value_is_byte() {
            // when
            var actual = PrimitiveTypes.checkByte(127);

            // then
            assertThat(actual).isEqualTo("byte b = 127");
        }

        @Test
        void value_is_no_byte() {
            // when
            var actual = PrimitiveTypes.checkByte(128);

            // then
            assertThat(actual).isEqualTo("no byte: 128");
        }
    }

    @Nested
    class GuardedPatterns {
        @Test
        void positive_byte() {
            // when
            var actual = PrimitiveTypes.guardedPatterns(124);

            // then
            assertThat(actual).isEqualTo("positive byte value: 124");
        }

        @Test
        void negative_byte() {
            // when
            var actual = PrimitiveTypes.guardedPatterns(-124);

            // then
            assertThat(actual).isEqualTo("negative or not of type byte: -124");
        }

    }

}