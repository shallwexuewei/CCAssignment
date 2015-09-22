package ch3.cbc.xuewei.ece.cmu;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution36 {
	
	public abstract static class Animal {
		private int order;
		private String name;
		public Animal(int order, String name) {
			super();
			this.order = order;
			this.name = name;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	public static class Dog extends Animal{
		public Dog(int order, String name) {
			super(order, name);
		}
	}
	
	public static class Cat extends Animal{
		public Cat(int order, String name) {
			super(order, name);
		}
	}
		
	public static class AnimalShelter{
		LinkedList<Dog> dogs;
		LinkedList<Cat> cats;
		
		public void enqueue(Animal animal) {
			if(animal instanceof Dog){
				dogs.add((Dog) animal);
			} else if(animal instanceof Cat){
				cats.add((Cat) animal);
			}
		}
		
		public Animal dequeueAny() {
			if(dogs.isEmpty() && cats.isEmpty()) {
				throw new EmptyStackException();
			}
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if(dog.getOrder() < cat.getOrder()) {
				return dogs.remove();
			} else {
				return cats.remove();
			}
		}
		
		public Dog dequeueDog(){
			if(dogs.isEmpty())
				throw new EmptyStackException();
			return dogs.remove();
		}
		
		public Cat dequeueCat() {
			if(cats.isEmpty())
				throw new EmptyStackException();
			return cats.remove();
		}
	}

	public static void main(String[] args) {

	}

}
