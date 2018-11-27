#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	char sentence[1000000];

	gets(sentence); //입력이 있을 때까지의 모든 문자 입력 읽어냄

	int count = 1;

	if (sentence[0] == ' ')
	{
		for (int i = 1; i < strlen(sentence); i++)
		{
			if (sentence[i] == ' ')
			{
				count++;
			}
		}
	}


	else
	{
		for (int i = 0; i < strlen(sentence); i++)
		{
			if (sentence[i] == ' ')
			{
				count++;
			}
		}
	}
	printf("%d", count);

	return 0;
}