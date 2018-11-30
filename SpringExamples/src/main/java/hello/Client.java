package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String prenom;
    private String name;
    private String age;
    private String email;
    private String numero;

    protected Client() {}
    
    public Client(String prenom, String nom, String age, String email, String numero)
    {
    	this.prenom = prenom;
        this.name = nom;
        this.age=age;
        this.email=email;
        this.numero=numero;
    }
    
    @Override
    public String toString() {
        return String.format(
                "%s	%s %s %s ",
                name, prenom, email, numero);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
