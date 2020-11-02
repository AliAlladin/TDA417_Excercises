public class main {
    public static void main(String[] args) {
        new main().program();
    }

    private void program() {
        System.out.println(isPalindrome("madamimadam"));
    }

    boolean isPalindrome(String original){
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        if (original.equals(reversed)){
            return true;
        }
        else {
            return false;
        }
    }
}
