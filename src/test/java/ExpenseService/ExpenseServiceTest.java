package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(ProjectType.INTERNAL,"project1");
        // when
        // then
        assertSame(ExpenseService.getExpenseCodeByProjectTypeAndName(project),ExpenseType.INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project projectA = new Project(ProjectType.EXTERNAL,"Project A");
        // when
        // then
        assertSame(ExpenseService.getExpenseCodeByProjectTypeAndName(projectA),ExpenseType.EXPENSE_TYPE_A);

    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project projectB = new Project(ProjectType.EXTERNAL,"Project B");
        // when
        // then
        assertSame(ExpenseService.getExpenseCodeByProjectTypeAndName(projectB),ExpenseType.EXPENSE_TYPE_B);

    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project otherProject = new Project(ProjectType.EXTERNAL,"Other Project");
        // when
        // then
        assertSame(ExpenseService.getExpenseCodeByProjectTypeAndName(otherProject),ExpenseType.OTHER_EXPENSE);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        Project unexpectProject = new Project(ProjectType.UNEXPECTED_PROJECT_TYPE, "unexpect project");
        // when
        // then
        assertThrows(UnexpectedProjectTypeException.class,() ->ExpenseService.getExpenseCodeByProjectTypeAndName(unexpectProject));
    }
}