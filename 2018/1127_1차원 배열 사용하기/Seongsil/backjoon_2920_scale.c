/*baekjoon- 2920. À½°è
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main(void)
{
	char *scale = malloc(sizeof(char) * 10); //read-only, should make a space that string could be stored
	char *result = { 0 };
	scanf("%[^\n]s", scale); //scan until "\n" appears

	if (!strcmp(scale, "1 2 3 4 5 6 7 8")) //compare two strings
	{
		result = "ascending";
	}

	else if (!strcmp(scale, "8 7 6 5 4 3 2 1"))
	{
		result = "descending";
	}

	else
	{
		result = "mixed";
	}
	printf("%s\n", result);
	return 0;
}