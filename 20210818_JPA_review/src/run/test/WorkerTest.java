package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import model.entity.Worker;

@Slf4j
public class WorkerTest {
	
	@Test
	public void workerCrud() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Worker worker1 = new Worker("개미1", "가사원", 25, 250);
		Worker worker2 = new Worker("개미2", "나대리", 27, 350);
		Worker worker3 = new Worker("개미3", "다선임", 29, 450);
		Worker worker4 = new Worker("개미4", "라과장", 33, 550);
		Worker worker5 = new Worker("개미5", "마부장", 38, 600);
		Worker worker6 = new Worker("개미6", "바이사", 44, 650);
		Worker worker7 = new Worker("개미7", "사책임", 49, 700);
		
		em.persist(worker1);
		em.persist(worker2);
		em.persist(worker3);
		em.persist(worker4);
		em.persist(worker5);
		em.persist(worker6);
		em.persist(worker7);
		
		worker5.setPay(620);
		
		System.out.println("\n■ ■ ■ 한 명 찾기");
		Worker oneFindWorker = em.find(Worker.class, "개미6");
		System.out.println(oneFindWorker);
		
		System.out.println("\n■ ■ ■ 총 인원 수 출력하기");
		List<Worker> allWorker = em.createQuery("select m from Worker m", Worker.class).getResultList();
		System.out.println("사원 수: " + allWorker.size());
		
		for(Worker m : allWorker) {
			System.out.println(m);
		}
		
		System.out.println("\n■ ■ ■ 삭제 후 검색 해보기");
		em.remove(worker4);
		
		tx.commit();
		
		oneFindWorker = em.find(Worker.class, "개미4");
		System.out.println(oneFindWorker);
	}

}
