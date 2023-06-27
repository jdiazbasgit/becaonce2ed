package once.curso.proyectobanco.dtos;

import java.util.Calendar;

import lombok.Data;

@Data
public class TransactionDto {

	private int id;
	private Calendar date;
	private double current;
	private int descriptionId;
	private int currentAccountId;
}
