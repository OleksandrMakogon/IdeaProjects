package com.epam.training.Calculator;

import com.google.common.hash.Hasher;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import static com.google.common.hash.Hashing.md5;

public class HashCalculator {

    public String hash(String toHash) {
         Function<String, String> hash = (String input) -> {
            Hasher hasher = md5().newHasher();
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


