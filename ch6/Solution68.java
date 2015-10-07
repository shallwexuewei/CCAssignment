package ch6.cbc.xuewei.ece.cmu;

import java.util.Random;

public class Solution68 {
	public static class EggDropProblem {
		private int breakingFloor;
		private int countDrops = 0;

		public EggDropProblem(int breakingFloor) {
			this.breakingFloor = breakingFloor;
			this.countDrops = 0;
		}

		public int getCountDrops() {
			int height = 100;

			int previousFloor = 0;
			boolean isBroken = false;
			int floorDropFirstEgg = 14;

			// drop the first egg
			for (int interval = 14; !isBroken && floorDropFirstEgg <= height; interval--) {
				isBroken = drop(floorDropFirstEgg);
				previousFloor = floorDropFirstEgg;
				floorDropFirstEgg += interval;
			}

			isBroken = false;
			// drop the second egg from the previousFloor+1 and one floor higher
			// each time
			for (int floorDropSecondEgg = previousFloor + 1; floorDropSecondEgg < floorDropFirstEgg
					&& floorDropSecondEgg <= height && !isBroken; floorDropSecondEgg++) {
				isBroken = drop(floorDropSecondEgg);
			}
			return countDrops;

		}

		public boolean drop(int floor){
			countDrops++;
			return (floor >= breakingFloor);
		}
		
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int breakingFloor = random.nextInt(100) + 1;
		Solution68.EggDropProblem problem = new Solution68.EggDropProblem(breakingFloor);
		System.out.println("breaking floor: " + breakingFloor);
		System.out.println("the number total drops: " + problem.getCountDrops());
		
		for(int i = 0; i < 100; i++) {
			breakingFloor = random.nextInt(100) + 1;
			problem = new Solution68.EggDropProblem(breakingFloor);
			assert(problem.getCountDrops() <= 14);
		}
		
		/*
		 * There are 100 floors but only 2 eggs.
		 * So if we break 1 egg on bth floor and if the highest non-breaking floor we know so far is nth floor, 
		 * give n < b. Then we need to linear search the floor from n+1 to b-1 to find the highest non-breaking
		 * floor.
		 * 
		 * To minimize the number of drops for the worst case, we should balance the load to reduce the cost of
		 * linear search after the broken of the first egg.
		 * Assume the number of drops of two eggs are D1 and D2 respectively, and D2 is the cost of linear search.
		 * To minimize the number of total drops, we need to balance the sum of D1 and D2. 
		 * 
		 * Because after every drop of the first egg, D1 increase by 1, in order to balance D1+D2, we should 
		 * guarantee D2 decrease by 1 accordingly. So we need to decrease the cost of linear search by 1. 
		 * It means that the interval between the (i+1)th drop's floor and ith drop's floor of the first egg 
		 * should be one smaller than the interval between ith floor and (i-1)th.
		 * Assume the first egg starts at floor f, then we have the equation
		 * f + (f-1) + (f-2) + ... + 1 = 100
		 * f(f+1)/2 = 100
		 * finally we get f = 13.65.
		 * 
		 * Because if we round f to 13, the sum of the sequence f, f-1, ..., 1 cannot be 100, but only 91, 
		 * we round f up to 14.
		 * So the minimum worst case's steps' number is 14.
		 * 
		 */

	}

}
