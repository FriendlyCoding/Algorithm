/*baekjoon- 2577. 숫자의 개수
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main(void)
{
	int a;
	int result = 1;
	int arr[10] = { 0 };

	for (int i = 0; i < 3; i++)
	{
		scanf("%d", &a);
		result *= a; // MAXIMUM 10^3*10^3*10^3 = 10*9, enough to use 'int'(less than 2,147,483,647)
	}

	for (int i = 0; result > 0; i++) //if result is 0, break.
	{
		arr[result % 10] += 1; /
		result /= 10;
	}

	for (int i = 0; i < 10; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;
}
