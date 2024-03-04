package springboot.appjpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
// import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import springboot.appjpa.dto.PersonDto;
import springboot.appjpa.entities.Person;
import springboot.appjpa.repositories.PersonRepository;

@SpringBootApplication
public class AppJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// ! METODOS CRUDE
		// create();
		// update();
		// deleted();
		// deleted2();

		// ? OTROS METODOS
		// list();
		// findOne();
		// personaliceQueries();
		// personaliceQueries2();
		// personaliceDistinct();
		// personalizedQueriesConcatUpperAndLowerCase();
		// queryBetween();
		// queryBetweenAndOrderBy();
		// coundMinAndMax();
		// lengMethod();
		// resumenFuncionesAgregacion();
		// subQueries();
		whereIn();
	}

	// importar de org.springFramework
	@Transactional
	@SuppressWarnings("null")
	// ? Metodo que crea un registro en base de datos
	public void create() {
		Scanner newScaner = new Scanner(System.in);
		String name = newScaner.next();
		String lastName = newScaner.next();
		String programmingLanguage = newScaner.next();
		newScaner.close();

		Person person = new Person(null, name, lastName, programmingLanguage);
		Person newPerson = personRepository.save(person);
		System.out.println(newPerson);

		personRepository.findById(newPerson.getId()).ifPresent(pers -> System.out.println(pers));

	}

	// ? Metodo para actualizar un registro en base de datos
	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario al que quiere actualizar: ");
		Long id = scanner.nextLong();

		Optional<Person> userFound = personRepository.findById(id);

		/*
		 * ! Sin validación
		 * userFound.ifPresent(person -> {
		 * System.out.println("Ingrese el lenguaje de progamación: ");
		 * String programmingLanguage = scanner.next();
		 * person.setProgrammingLanguage(programmingLanguage);
		 * Person personDb = personRepository.save(person);
		 * System.out.println(personDb);
		 * });
		 */

		// ! Con validación
		if (userFound.isPresent()) {

			Person person = userFound.orElseThrow();
			System.out.println("Ingrese el lenguaje de progamación: ");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb = personRepository.save(person);
			System.out.println(personDb);

		} else {
			System.out.println("Person not found");
		}

		scanner.close();
	}

	// ? Metodo para eliminar un registro dentro de la base de datos
	@Transactional
	public void deleted() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario que quiere eliminar");
		Long id = scanner.nextLong();
		personRepository.deleteById(id);

		// mostrando todos los registros
		personRepository.findAll().forEach(System.out::println);

		scanner.close();
	}

	// ? Metodo para eliminar un registro dentro de la base de datos
	@SuppressWarnings("ignored")
	@Transactional
	public void deleted2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario que quiere eliminar");
		Long id = scanner.nextLong();
		personRepository.deleteById(id);

		Optional<Person> personOptional = personRepository.findById(id);
		personOptional.ifPresentOrElse(personRepository::delete, () -> {
			System.out.println("Person not found");
		});

		// mostrando todos los registros
		personRepository.findAll().forEach(System.out::println);

		scanner.close();
	}

	// ?----------------------------- OTROS METODOS
	// --------------------------------------------------------

	@Transactional(readOnly = true)
	public void personaliceQueries() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------- CONSULTAS PERSONALIZADAS ----------------------");
		System.out.println("---------------- obtener nombre por el id ----------------------");
		System.out.println("Ingrese el id para obtener el nombre: ");
		Long id = scanner.nextLong();

		String name = personRepository.getNameById(id);
		System.out.println(name);

		System.out.println("---------------- obtener nombre y apellido por el id ----------------------");
		System.out.println("Ingrese el id para obtener el nombre junto con el apellido: ");
		Long idDb = scanner.nextLong();

		String fullName = personRepository.getFullNameById(idDb);
		System.out.println(fullName);

		System.out.println("---------------- obtener nombre y apellido por el id ----------------------");
		System.out.println("Ingrese el id para obtener el registro completo: ");
		Long idDb3 = scanner.nextLong();
		Object[] fullObject = (Object[]) personRepository.obtenerPersonDataFullObject(idDb3);
		System.out.println("Id: " + fullObject[0] + " Nombre: " + fullObject[1] + " Apellido: "
				+ fullObject[2] + " Leguaje: " + fullObject[3]);

		System.out.println("---------------- obtener nombre y apellido por el id ----------------------");
		System.out.println("Full List obtenida: ");
		List<Object[]> fullList = personRepository.obtenerPersonDataFullList();
		fullList
				.forEach(personReg -> System.out.println("Id: " + personReg[0] + " Nombre: " + personReg[1] + " Apellido: "
						+ personReg[2] + " Leguaje: " + personReg[3]));

		scanner.close();
	}

	@Transactional(readOnly = true)
	public void personaliceQueries2() {

		System.out.println("---------------- Consulta por objeto persona ----------------------");
		System.out.println("Ingrese el id para obtener el registro completo: ");
		List<Object[]> personReg = personRepository.findAllMixPerson();
		personReg.forEach(person -> {
			System.out.println("Programing Language" + person[1] + "Object Person" + person[0]);
		});

		System.out
				.println("------- Consulta  que puebla y devuelve  objeto entity de una instancia personalizada -------");
		List<Person> personalicer = personRepository.finAllPersonalicePersonList();
		personalicer.forEach(System.out::println);

		System.out
				.println("------- Consulta que puebla y devuelve objeto Dto de una clase personalizada -------");
		List<PersonDto> persondto = personRepository.finAllPersonalicePersonDto();
		persondto.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void personaliceDistinct() {

		System.out.println("---------------- Consulta con nombres de persona ----------------");
		List<String> namesList = personRepository.finAllNames();
		namesList.forEach(System.out::println);

		System.out.println("---------------- Consulta de nombres unicos de persona ----------------");
		List<String> namesDistinct = personRepository.finAllNamesDistinct();
		namesDistinct.forEach(System.out::println);

		System.out.println("---------------- Consulta de lenguajes unicos de programación ----------------");
		List<String> programsDistinct = personRepository.finAllProgrammingDistinct();
		programsDistinct.forEach(System.out::println);

		System.out.println("---------------- Consulta de cuantos lenguajes unicos de programación ----------------");
		Long countprogramsDistinct = personRepository.countProgrammingDistinct();
		System.out.println(countprogramsDistinct);

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase() {

		System.out.println("---------------- Consulta con CONCAT para obtener los nombres completos ----------------");
		List<String> fullNameConcat = personRepository.findAllFullNameConcat();
		fullNameConcat.forEach(System.out::println);

		System.out.println("---------------- Consulta con || para obtener los nombres completos ----------------");
		List<String> fullNameConcat2 = personRepository.findAllFullNameConcat2();
		fullNameConcat2.forEach(System.out::println);

		System.out.println("---------------- Consulta con UPPER para obtener los nombres completos ----------------");
		List<String> fullNameConcatUpper = personRepository.findAllFullNameConcatUpper();
		fullNameConcatUpper.forEach(System.out::println);

		System.out.println("---------------- Consulta con LOWER para obtener los nombres completos ----------------");
		List<String> fullNameConcatLower = personRepository.findAllFullNameConcatLower();
		fullNameConcatLower.forEach(System.out::println);

		System.out.println(
				"---------------- Consulta con UPPER and LOWER para obtener los nombres completos ----------------");
		List<Object[]> fullNameConcatMix = personRepository.findAllFullNameConcatMix();
		fullNameConcatMix.forEach(person -> {
			System.out.println("Nombre: " + person[0] + " Apellido: " + person[1]);
		});

	}

	// ?----------------------------- BETWEEN and ORDER BY METODS
	// ------------------------------

	@Transactional
	public void queryBetween() {

		System.out.println("---------------- Consulta con BETWEEN para definir un rango de obtención ----------------");
		List<PersonDto> betweenById = personRepository.findBetweenById();
		betweenById.forEach(System.out::println);

		System.out.println("---------------- Consulta con BETWEEN con QUERY Metod----------------");
		List<Person> betweenById2 = personRepository.findByIdBetween(1L, 5L);
		betweenById2.forEach(System.out::println);

	}

	@Transactional
	public void queryBetweenAndOrderBy() {

		System.out.println("---------------- Consulta con BETWEEN con ORDER BY name----------------");
		List<PersonDto> betweenOrderById = personRepository.findBetweenOrderById();
		betweenOrderById.forEach(System.out::println);

		System.out.println("---------------- Consulta con BETWEEN con ORDER BY name DESC----------------");
		List<PersonDto> betweenOrderByIdDesc = personRepository.findBetweenOrderDescById();
		betweenOrderByIdDesc.forEach(System.out::println);

		System.out.println("---------------- Consulta con BETWEEN con ORDER BY name ASC----------------");
		List<PersonDto> betweenOrderByIdAsc = personRepository.findBetweenOrderAscById();
		betweenOrderByIdAsc.forEach(System.out::println);

		System.out.println("---------------- Consulta lista con ORDER DESC----------------");
		List<Person> betweenOrderByIdAscGet = personRepository.getAllOrder();
		betweenOrderByIdAscGet.forEach(System.out::println);

		System.out.println("---------------- Consulta lista con QUERY METHOD and ORDER DESC----------------");
		List<Person> queryOrderDesc = personRepository.findAllByOrderByNameDesc();
		queryOrderDesc.forEach(System.out::println);

	}

	@Transactional
	public void coundMinAndMax() {

		System.out.println("---------------- Consulta el total de personas con COUNT ----------------");
		Long totalPerson = personRepository.totalPerson();
		System.out.println(totalPerson);

		System.out.println("---------------- Consulta el ID minimo con min ----------------");
		Long minById = personRepository.minId();
		System.out.println(minById);

		System.out.println("---------------- Consulta el ID maximo com max ----------------");
		Long maxById = personRepository.maxId();
		System.out.println(maxById);

	}

	@Transactional
	public void lengMethod() {

		System.out.println("---------------- Consulta el LENGTH que tienen cada nombre ----------------");
		List<Object[]> personLength = personRepository.getPersonLength();
		personLength.stream().forEach(person -> {
			String name = (String) person[0];
			Integer length = (Integer) person[1];
			System.out.println("nombre " + name + " tamaño " + length);
		});

		System.out.println("---------------- Consulta el nombre con el length minimo ----------------");
		Integer personLengthMin = personRepository.getPersonMinLength();
		System.out.println("nombre con length min " + personLengthMin);

		System.out.println("---------------- Consulta el nombre con el length maximo ----------------");
		Integer personLengthMax = personRepository.getPersonMaxLength();
		System.out.println("nombre con length max " + personLengthMax);
	}

	public void resumenFuncionesAgregacion() {

		System.out.println("---------------- Consulta el LENGTH que tienen cada nombre ----------------");
		Object[] personLength = (Object[]) personRepository.getResumeAggregationFunction();
		System.out.println("Min " + personLength[0] + " Max " + personLength[1] + " Suma " + personLength[2]
				+ " Promedio " + personLength[3] + " Count " + personLength[3]);
	}

	public void subQueries() {
		System.out.println("---------------- Subconsulta por el nombre mas corto y su length ----------------");
		List<Object[]> subQuery = personRepository.getShorterName();
		subQuery.forEach(person -> {
			String name = (String) person[0];
			Integer length = (Integer) person[1];
			System.out.println("nombre " + name + " tamaño " + length);
		});

		System.out.println("---------------- Subconsulta que trae el nombre por el id max ----------------");
		Optional<Person> subQueryIdMax = personRepository.getLastRegistration();
		subQueryIdMax.ifPresent(System.out::println);
	}

	// ? ----------------------------Where In And Not In-----------------------------------
	@Transactional(readOnly = true)
	public void whereIn() {

		System.out.println("---------------- Subconsulta where In ----------------");
		List<Person> person = personRepository.getPersonById();
		person.forEach(System.out::println);

		System.out.println("---------------- Subconsulta where In Dinamic ----------------");
		List<Person> person1 = personRepository.getPersonByIdList(Arrays.asList(1L, 2l, 4L));
		person1.forEach(System.out::println);
		
		System.out.println("---------------- Subconsulta where In Dinamic ----------------");
		List<Person> person2 = personRepository.getPersonByIdListNotIn(Arrays.asList(1L, 2l, 4L));
		person2.forEach(System.out::println);

	}

	// ? -------------------------------------------------------------------

	@Transactional(readOnly = true)
	public void findOne() {

		// * Simplificado
		personRepository.findById(1L).ifPresent(pers -> System.out.println(pers));

		personRepository.findOne(1L).ifPresent(pers -> System.out.println(pers));

		personRepository.findOneName("Pepe").ifPresent(pers -> System.out.println(pers));

		personRepository.findOneLikeName("pe").ifPresent(pers -> System.out.println(pers));

		personRepository.findByNameContaining("Ma").ifPresent(pers -> System.out.println(pers));
		/*
		 * Para capturar el objeto presente usamos orElseThrow() bien sea de que exista
		 * o no dentro de la base de datos el id ingresado, si no existe ejecuta una
		 * excepcion isPresent() -> si existe, isEmpty() -> no existe
		 */

		/*
		 * Person onePerson = null;
		 * Optional<Person> optinalPerson = personRepository.findById(8L);
		 * if (optinalPerson.isPresent()) {
		 * onePerson = optinalPerson.orElseThrow();
		 * } else {
		 * throw new Error("Id not Found");
		 * }
		 * System.out.println(onePerson);
		 */
	}

	@Transactional(readOnly = true)
	public void list() {
		// Mostrar todos los registros
		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(person -> System.out.println(person));

		// Mostrar una lista con los usuarios que utilicen un lenguaje de programacion
		// especifico
		List<Person> personsProgramming = (List<Person>) personRepository.findByProgrammingLanguage("Java");
		personsProgramming.stream().forEach(personProgram -> System.out.println(personProgram));

		// Mostrar una lista con los usuarios que utilicen un lenguaje de programacion
		// especifico
		List<Person> programmingAndName = (List<Person>) personRepository.findByProgrammingLanguageAndName("John",
				"JavaScript");
		programmingAndName.stream().forEach(personProgram -> System.out.println(personProgram));

		List<Object[]> personValues = personRepository.obtenerPersonData();
		personValues.stream().forEach(personV -> System.out.println(personV[0] + " es experto en " + personV[1]));
	}
}
