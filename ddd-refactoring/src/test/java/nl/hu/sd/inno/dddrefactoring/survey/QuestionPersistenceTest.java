package nl.hu.sd.inno.dddrefactoring.survey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class QuestionPersistenceTest {

    @Autowired
    private EntityManager entities;


    @Test
    public void canPersistQuestions() {
        SurveyQuestion question = new SurveyQuestion("Alles ok?");
        SurveyAnswer ja = new SurveyAnswer("Ja");
        SurveyAnswer nee = new SurveyAnswer("Nee");

        question.addAnswer(ja);
        question.addAnswer(nee);

        entities.persist(question);

        entities.flush();
        entities.clear();

        SurveyQuestion found = entities.find(SurveyQuestion.class, question.getId());

        assertEquals("Alles ok?", found.getLabel());
        assertEquals(2, found.getAnswers().size());
        assertEquals("Ja", found.getAnswers().get(0).getLabel());
        assertEquals("Nee", found.getAnswers().get(1).getLabel());
    }


//    @Test
//    public void canMoveAnswerBetweenQuestions() {
//        SurveyQuestion question = new SurveyQuestion("Alles ok?");
//        SurveyAnswer ja = new SurveyAnswer("Ja");
//        SurveyAnswer nee = new SurveyAnswer("Nee");
//        question.addAnswer(ja);
//        question.addAnswer(nee);
//
//        SurveyQuestion question2 = new SurveyQuestion("Tijd voor nog een test?");
//
//        question2.addAnswer(ja);
//
//        assertTrue(question2.getAnswers().contains(ja));
//        assertFalse(question.getAnswers().contains(ja));
//        assertEquals(question2, ja.getQuestion());
//    }

//    @Test
//    public void canMoveAnswerBySettingQuestion() {
//        SurveyQuestion question = new SurveyQuestion("Alles ok?");
//        SurveyAnswer ja = new SurveyAnswer("Ja");
//        SurveyAnswer nee = new SurveyAnswer("Nee");
//        question.addAnswer(ja);
//        question.addAnswer(nee);
//
//        SurveyQuestion question2 = new SurveyQuestion("Tijd voor nog een test?");
//
//        ja.setQuestion(question2);
//
//        assertTrue(question2.getAnswers().contains(ja));
//        assertFalse(question.getAnswers().contains(ja));
//        assertEquals(question2, ja.getQuestion());
//    }
}
