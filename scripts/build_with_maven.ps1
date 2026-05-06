<#
PowerShell script to ensure Maven is available and build the project using Maven or Maven Wrapper.
Steps:
- Prefers local Maven install at C:\Program Files\Maven\apache-maven-3.9.11\bin if present.
- Falls back to Maven Wrapper (mvnw.cmd) if mvn is not available.
- Runs: mvn -DskipTests package
- Exit codes: 0 on success, non-zero on failure.
#>

$ErrorActionPreference = 'Stop'

# 1) Try to add the default Maven bin path to PATH temporarily
$defaultMavenBin = "C:\Program Files\Maven\apache-maven-3.9.11\bin"
if (Test-Path $defaultMavenBin) {
  $env:PATH = $env:PATH + ";" + $defaultMavenBin
  Write-Host "[Maven] Added default Maven bin to PATH: $defaultMavenBin"
}

# 2) Try to run mvn directly, or fall back to mvnw.cmd
function Invoke-Build {
  if (Get-Command mvn -ErrorAction SilentlyContinue) {
    Write-Host "[Build] Using mvn from PATH"
    & mvn -DskipTests package
  } elseif (Test-Path .\mvnw.cmd) {
    Write-Host "[Build] Using Maven Wrapper (mvnw.cmd)"
    & .\mvnw.cmd -DskipTests package
  } else {
    Write-Error "[Build] Maven not found. Please install Maven 3.9.11 and ensure it's in PATH, or include the Maven Wrapper in the repo."
    exit 1
  }
}

Invoke-Build
