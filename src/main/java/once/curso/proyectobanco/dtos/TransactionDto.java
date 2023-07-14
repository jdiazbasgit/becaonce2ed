package once.curso.proyectobanco.dtos;

import java.util.Calendar;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;

@Data
public class TransactionDto {

	private int id;
	private Calendar date;
	private double current;
	private int description;
	private int currentAccountOrigen;
	private int currentAccountDestino;
}
