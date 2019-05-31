package todo.model;

import org.junit.Test;
import todo.Status;

import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @Test
    public void getById() {
        assertThat(Status.getById(0)).isEqualTo(Status.TODO);
        assertThat(Status.getById(1)).isEqualTo(Status.DONE);
        assertThat(Status.getById(2)).isEqualTo(Status.BLOCKED);
        assertThat(Status.getById(3)).isEqualTo(Status.POSTPONED);
        assertThat(Status.getById(4)).isEqualTo(Status.CANCELLED);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getById_throwsArrayIndexOutOfBoundsException() {
        Status.getById(999999);
    }
}
