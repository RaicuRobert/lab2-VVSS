package lab2926.repository;

import jdk.Exported;
import junit.framework.TestCase;
import lab2926.exceptions.RepositoryException;
import lab2926.model.Member;
import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 * Created by Robert on 13.03.2018.
 */
public class MemberRepositoryTest extends TestCase {
    MemberRepository memberRepository;

    public void setUp() throws Exception {
        super.setUp();
        memberRepository= new MemberRepository();
        memberRepository.addMember(new Member("Andrei",0));
    }

    public void testUserExists() throws Exception {
        assertTrue(memberRepository.userExists(0));
        assertFalse(memberRepository.userExists(2));
    }

    @Test(expected = RepositoryException.class)
    public void testAddMember() throws Exception {
        memberRepository.addMember(new Member("Ana",1));
        assertTrue(memberRepository.userExists(0));
        assertTrue(memberRepository.userExists(1));
        assertFalse(memberRepository.userExists(2));
        memberRepository.addMember(new Member("a",1));
    }

}