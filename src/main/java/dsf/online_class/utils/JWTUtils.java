package dsf.online_class.utils;

import dsf.online_class.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JWTUtils {

    private static final  long EXPIRE = 6000*60*24*7;//过期时间
    private static final String SECRET ="";//秘钥
    private static final String TOKEN_PREFIX = "dsf";

    private static final String SUBJECT = "dsf";
    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT).claim("head_img",user.getHeadImg()).
                claim("id",user.getId()).
                claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX+token;
        return token;
    }

    public static final Claims checkJWT(String token){
        try {

            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        }
        catch (Exception e)
        {
            return null;
        }

    }
}
