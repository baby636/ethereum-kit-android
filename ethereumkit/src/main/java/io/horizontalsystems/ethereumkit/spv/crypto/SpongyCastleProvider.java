package io.horizontalsystems.ethereumkit.spv.crypto;

import org.spongycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

public final class SpongyCastleProvider {

    private static class Holder {
        private static final Provider INSTANCE;

        static {
            Provider p = Security.getProvider("SC");

            INSTANCE = (p != null) ? p : new BouncyCastleProvider();

            INSTANCE.put("MessageDigest.ETH-KECCAK-256", "io.horizontalsystems.ethereumkit.spv.crypto.digest.Keccak256");
            INSTANCE.put("MessageDigest.ETH-KECCAK-512", "io.horizontalsystems.ethereumkit.spv.crypto.digest.Keccak512");
        }
    }

    public static Provider getInstance() {
        return Holder.INSTANCE;
    }
}
