/**
 * name: Deema Alrashdan
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import lifeform.TestLifeForm;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import lifeform.TestAlien;
import lifeform.TestHuman;

/**
 * Runs all of the tests in this project
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	TestLifeForm.class,
	TestCell.class,
	TestEnvironment.class,
	TestHuman.class,
	TestAlien.class,
	TestRecoveryNone.class,
	TestRecoveryLinear.class,
	TestRecoveryFractional.class,
	TestSimpleTimer.class
})
public class AllGameTests
{
}