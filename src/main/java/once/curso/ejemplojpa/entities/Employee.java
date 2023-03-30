package once.curso.ejemplojpa.entities;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;
import lombok.Data;
@Data
@Entity
@Table (name = "employees") 
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String nif;
private String phone;
//@Column (name = "birth_date"), se llaman diferente (birth_date en sql y birthDate en nuestro jpa. Sería necesario indicarlo
//PERO sb jpa es muy listo e interpreta el guión bajo como camell case
@Temporal (TemporalType.DATE)
private Calendar birthDate;

@Temporal (TemporalType.DATE)
private Calendar dateHight;

@Temporal (TemporalType.DATE)
private Calendar lowDate;

@ManyToOne
//En proncipio también buscaría el joincolumn con los guiones, pero bueno.. los dejamos para practicar
@JoinColumn (name = "personal_information_id")
private PersonalInformation personalInformation;


@ManyToOne
@JoinColumn (name = "laboral_information_id")
private PersonalInformation laboralInformation;


@ManyToOne
@JoinColumn (name = "companies_id")
private Company Company;
}
