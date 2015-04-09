package org.teachingkidsprogramming.recipes.quizzes.tests;

import junit.framework.TestCase;

import org.junit.Test;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.approvals.lite.reporters.ClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleSquareQuizGrader;
import org.teachingkidsprogramming.recipes.quizzes.graders.SquareQuiz;

@UseReporter({ClipboardReporter.class, DiffReporter.class})
public class SimpleSquareQuizTest {
    public static class SimpleSquareCorrectQuiz implements SquareQuiz {
        public void question1() {
            // Move the tortoise 110 pixels
            Tortoise.move(110);
        }

        public void question2() {
            // Turn the tortoise 1/5 of 360 degrees to the right
            Tortoise.turn(360 / 5);
        }

        public void question3() {
            // Change the color the tortoise draws to yellow
            Tortoise.setPenColor(PenColors.Yellows.Yellow);
        }

        public void question4() {
            // Change the width of the line the tortoise draws to 5 pixels
            Tortoise.setPenWidth(5);
        }
    }

    @Test
    public void testCorrect() throws Exception {
        JUnitUtils.assumeNotHeadless();
        SimpleSquareQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
        new SimpleSquareQuizGrader().grade(new SimpleSquareCorrectQuiz());
        TortoiseUtils.verifyForOs();
    }

    public static class SimpleSquareIncorrectQuiz implements SquareQuiz {
        public void question1() {
            // Move the tortoise 110 pixels
            Tortoise.move(75);
        }

        public void question2() {
            // Turn the tortoise 1/5 of 360 degrees to the right
            Tortoise.turn(360.0 / 6);
        }

        public void question3() {
            // Change the color the tortoise draws to yellow
            Tortoise.setPenColor(PenColors.Yellows.Gold);
        }

        public void question4() {
            // Change the width of the line the tortoise draws to 5 pixels
            Tortoise.setPenWidth(9);
        }
    }

    @Test
    public void testIncorrect() throws Exception {
        JUnitUtils.assumeNotHeadless();
        SimpleSquareQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
        new SimpleSquareQuizGrader().grade(new SimpleSquareIncorrectQuiz());
        TortoiseUtils.verifyForOs();
    }
}
