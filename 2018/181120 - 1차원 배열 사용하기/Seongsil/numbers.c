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
		result *= a;
	}

	for (int i = 0; result > 0; i++) //if result가 0 이면 for문을 빠져나간다.
	{
		arr[result % 10] += 1;
		result /= 10;
	}

	for (int i = 0; i < 10; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;
}