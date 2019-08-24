package game;

import com.badlogic.gdx.math.MathUtils;

public class Dice {

	private static int result;

	private static int roll(int dice, int size) {
		result = 0;
		for (int i = 0; i < dice; i++) {
			result += MathUtils.random(1, size);
		}
		return result;
	}
	
	public int rolld4(int dice) {
		return roll(dice, 4);
	}
	
	public int rolld6(int dice) {
		return roll(dice, 6);
	}
	
	public int rolld8(int dice) {
		return roll(dice, 8);
	}
	
	public int rolld10(int dice) {
		return roll(dice, 10);
	}
	
	public int rolld12(int dice) {
		return roll(dice, 12);
	}
	
	public int rolld20(int dice) {
		return roll(dice, 20);
	}
	
	public int rolld100(int dice) {
		return roll(dice, 100);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 4));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 6));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 8));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 10));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 12));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 20));
		}
		System.out.println("----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println(Dice.roll(1, 100));
		}
		System.out.println("----------------------------");

	}

}
