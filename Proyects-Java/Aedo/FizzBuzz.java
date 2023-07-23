class FizzBuzz{
    public static void main(String[] args) {
        int numeros[] = new int[101];
        for(int i = 0; i <= 100; i++){
            numeros[i] = i;
            if(numeros[i] % 3 == 0 && numeros[i] % 5 == 0){
                System.out.println("FizzBuzz");
            }else{
                if(numeros[i] % 3 == 0){
                    System.out.println("Fizz");
                }else{
                    if(numeros[i] % 5 == 0){
                        System.out.println("Buzz");
                    }else{
                        System.out.println(numeros[i]);
                    }
                }
            }
        }
    }
}