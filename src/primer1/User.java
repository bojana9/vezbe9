package primer1;

public class User {
	private String ime, prezime, role, country;
	
	public User(String ime, String prezime, String role, String country) {
		this.ime = ime;
		this.prezime = prezime;
		this.role = role;
		this.country = country;
	}
	
	public String toString() {
		return "Dodat korisnik " + ime + " " + prezime + " sa ulogom: " + role + " i drzavom: " + country + ".";
	}

}
