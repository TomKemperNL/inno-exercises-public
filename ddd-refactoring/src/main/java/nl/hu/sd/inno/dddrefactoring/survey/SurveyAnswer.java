package nl.hu.sd.inno.dddrefactoring.survey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class SurveyAnswer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    protected SurveyQuestion question;

    private String label;

    protected SurveyAnswer() {
    }

    public SurveyAnswer(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public SurveyQuestion getQuestion() {
        return question;
    }

    public void setQuestion(SurveyQuestion question) {
       this.question = question;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyAnswer that = (SurveyAnswer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
