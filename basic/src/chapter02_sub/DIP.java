package chapter02_sub;

// 의존성 역전 원칙

class Controller {
	IService service;
	
	Controller(IService service)	{
		this.service = service;
	}
	
	void controllerMethod() {
		System.out.println("Controller A");
		service.serviceMethod();
	}
	
	void controllerMethod2() {
		System.out.println("Controller A2");
		service.serviceMethod2();
	}
	
}

interface IService {
	public void serviceMethod();
	public void serviceMethod2();
}

class Service implements IService {
	IRepository repository;
	
	Service(IRepository repository) {
		this.repository = repository;
	}
	
	public void serviceMethod() {
		System.out.println("Service A");
		repository.repositoryMethod();
	}
	
	public void serviceMethod2() {
		System.out.println("Service A2");
		repository.repositoryMethod2();
	}
	
}

interface IRepository {
	public void repositoryMethod();
	public void repositoryMethod2();
}

class Repository implements IRepository {
	
	public void repositoryMethod() {
		System.out.println("Repository A");
	}
	
	public void repositoryMethod2() {
		System.out.println("Repository A2");
	}
	
}

class Repository2 implements IRepository {
	
	public void repositoryMethod() {
		System.out.println("Repository B");
	}
	
	public void repositoryMethod2() {
		System.out.println("Repository B2");
	}
}

public class DIP {

	public static void main(String[] args) {
		
		Repository repository = new Repository();
		Repository2 repository2 = new Repository2();
		
		Service service = new Service(repository);
		
		Controller controller = new Controller(service);
		controller.controllerMethod();
		controller.controllerMethod2();
		
	}
}