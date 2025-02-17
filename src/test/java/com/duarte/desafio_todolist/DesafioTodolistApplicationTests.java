package com.duarte.desafio_todolist;

import com.duarte.desafio_todolist.entity.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	private Todo todo;

	@BeforeEach
	void setUp() {
		todo = new Todo("Primeira tarefa", "Descrição da primeira tarefa", false, 1);
	}

	@AfterEach
	void tearDown() {
		todo = null; // Limpa o objeto após cada teste
	}

	@Test
	void testCreatedTodoSuccess() {
		Assertions.assertNotNull(todo);
		Assertions.assertEquals("Primeira tarefa", todo.getNome());
		Assertions.assertEquals("Descrição da primeira tarefa", todo.getDescricao());
		Assertions.assertFalse(todo.getRealizado());
		Assertions.assertEquals(1, todo.getPrioridade());
	}

	@Test
	void testCreatedTodoFailure() {
		assertThrows(IllegalArgumentException.class, () -> {
				new Todo("", "sem descricao", false, -1);
		});
	}

}
