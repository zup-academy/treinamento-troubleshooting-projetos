package br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb;

public class DeletePixKeyBcbRequest {

    private String key;
    private String participant = "ITAU_UNIBANCO_ISPB";

    public DeletePixKeyBcbRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getParticipant() {
        return participant;
    }
}
