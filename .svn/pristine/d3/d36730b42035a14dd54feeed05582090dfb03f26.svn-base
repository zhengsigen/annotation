package cn.zhengsigen.annotation;

public class AnnotationTestFile2 {

	public AnnotationTestFile2() {
	}

	public AnnotationTestFile2(int i) {
	}

	@TestX
	public void Test1() throws InterruptedException {

		Thread.sleep(3000);
	}

	@TestX(count = 20)
	public void Test2() {
		System.out.println("test2成功运行！");
	}

	@IgnoreX
	public void Test3() {
		System.out.println("test3成功运行！");
	}

	@TestX(expected = NullPointerException.class)
	public boolean Test4() {

		try {

			String name = null;

			boolean equals = name.equals("小明");

			System.out.println(equals);

		} catch (NullPointerException e) {

			return true;

		}

		return false;
	}

	@TestX
	public void Test5(int i) {
		System.out.println("test5成功运行！");
	}

	@TestX
	void Test6() {
		System.out.println("test6成功运行！");
	}

	@TestX
	private void Test7() {
		System.out.println("test7成功运行！");
	}

	@TestX
	protected void Test8() {
		System.out.println("test8成功运行！");
	}

	@TestX
	public static void Test9() {
		System.out.println("test9成功运行！");
	}

	@TestX
	public void Test10() {
		System.out.println("test10成功运行！");
	}

	@TestX
	public void Test12() {
		System.out.println("test12成功运行！");
	}
}
