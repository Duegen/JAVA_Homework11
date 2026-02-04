package HW.Tasks;

public class Cat implements Comparable<Cat>{
	private String name;
	private String breed;
	private Integer age;
	private Double weight;
	
	public Cat(String name, String breed, Integer age, Double weight) {
		super();
		if(name == null || name.isEmpty()) this.name = "unknown";
		else this.name = name;
		if(breed == null || breed.isEmpty()) this.breed = "unknown";
		else this.breed = breed;
		if(age > 0 && age <= 40) this.age = age;
		else this.age = 0;
		if(weight >= 0.3 && weight <= 25.)this.weight = weight;
		else this.weight = 0.;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public Integer getAge() {
		return age;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", breed=" + breed + ", age=" + age + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Cat other) {
		if(other == null) throw new IllegalArgumentException("null pointer recieved"); 
		int res = name.compareTo(other.getName());
		if(res == 0) {
			res = age.compareTo(other.getAge());
			if(res == 0)
				res = weight.compareTo(other.getWeight());
		}
		return res;
	}
	
	
}
