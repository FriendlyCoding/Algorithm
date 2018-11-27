/*baekjoon- 1152. 단어의 개수
Seongsil Heo */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	char sentence[1000000];

	//scanf("%[^\n]s",&sentence);
	gets(sentence);
	int count = 0;

	char *word = strtok(sentence, " ");
	
	//문자열의 주소값이 들어오면 거기서부터 분리를 시도하고, NULL이 들어오면 이전에 자기가 기억한 곳으로부터 분리 시도
	while (word != NULL) 
	{
		if (word != ' ') //맨앞 또는 맨뒤에 공백이 있는 경우 제거
		{
			count++;
		}

		word = strtok(NULL, " ");
	}
	printf("%d", count);

	return 0;
}