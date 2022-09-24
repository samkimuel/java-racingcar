package racingcar.step2;

import java.util.Objects;

public class Positive {

	private static final String NEGATIVE_NUMBER_MESSAGE = "유효하지 않은 수(음수)입니다.";

	private final int number;

	public Positive(String value) {
		this(toInt(value));
	}

	public Positive(int number) {
		validateNegativeNumber(number);

		this.number = number;
	}

	private static int toInt(String value) {
		return Integer.parseInt(value);
	}

	private void validateNegativeNumber(int number) {
		if (isNegative(number)) {
			throw new NumberFormatException(NEGATIVE_NUMBER_MESSAGE);
		}
	}

	public Positive plus(Positive positive) {
		return new Positive(this.number + positive.getNumber());
	}

	private boolean isNegative(int number) {
		return number < 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Positive positive = (Positive) o;
		return number == positive.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public int getNumber() {
		return this.number;
	}
}
