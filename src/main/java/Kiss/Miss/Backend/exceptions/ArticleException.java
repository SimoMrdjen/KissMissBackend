package Kiss.Miss.Backend.exceptions;

public class ArticleException extends Exception {

    public ArticleException(String message) {
        super(message);
    }

    public ArticleException(String message, Throwable cause) {
        super(message, cause);
    }
}

