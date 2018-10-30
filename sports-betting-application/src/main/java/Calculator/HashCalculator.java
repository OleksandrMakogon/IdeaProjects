package Calculator;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class HashCalculator {

    public String hash(String toHash) {
         Function<String, String> hash = (String input) -> {
            Hasher hasher = Hashing.md5().newHasher();
            hasher.putString(input, StandardCharsets.UTF_8);
            return hasher.hash().toString();
        };
        return hash.apply(toHash);
    }

//        public String hash(String toHash) {
//            return Hashing.md5()
//                    .newHasher()
//                    .putString(toHash, StandardCharsets.UTF_8)
//                    .toString();
//        }

    }


