package nl.hu.sd.inno.dddrefactoring.survey;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SurveyQuestion {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SurveyAnswer> answers = new ArrayList<>();

    private String label;

    public Long getId() {
        return id;
    }

    protected SurveyQuestion() {
    }

    public SurveyQuestion(String label) {
        this.label = label;
    }

    public List<SurveyAnswer> getAnswers() {
        return answers;
    }

    public void removeAnswer(SurveyAnswer a) {
        this.answers.remove(a);
    }

    public void addAnswer(SurveyAnswer a) {
        this.answers.add(a);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyQuestion that = (SurveyQuestion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
