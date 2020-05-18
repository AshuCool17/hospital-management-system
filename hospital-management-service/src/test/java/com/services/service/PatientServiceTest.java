/**
 * 
 */
package com.services.service;

/**
 * @author ashumaha
 *
 */
public class PatientServiceTest {

	@InjectMocks
	@Spy
    private RoleService roleService;
	
	@Mock
	private UserPasswordService userPasswordService; 
	
	@Mock
    private Validator validator;
	
	@Mock 
	private EnvironmentUtils mockEnvironmentUtils;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testVerifyRoleForUnauthenticatedRoleShouldReturnTrue() throws GlobalException {
		String email = "Email@email.com";
		String password = "P455W#RD";
		String basicAuth = "Basic " + Base64Utils.encodeToString((email + ":" + password).getBytes());
		String IP = "192.168.1.1";
		List<String> resetRole = new ArrayList<String>();
		resetRole.add(Constants.UNVERIFIED_ROLE);
		assertThat(roleService.verifyRoles(basicAuth, IP, resetRole, Permission.PASSWORD_UPDATE), is(true));
	}
	
}
